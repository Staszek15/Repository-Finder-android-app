import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main(vararg user: String) {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiInterface::class.java)
    val requestCall = apiService.getData("https://api.github.com/users/Staszek15/repos")


    requestCall.enqueue(object : Callback<List<RepositoryItem>> {

        override fun onResponse(call: Call<List<RepositoryItem>>, repoResponse: Response<List<RepositoryItem>>) {

            if (repoResponse.isSuccessful) {
                val apiResponse = repoResponse.body()

            } else {
                val responseCode = repoResponse.code()
                val errorBody = repoResponse.errorBody()?.string()
                if (responseCode == 404) {
                    val jsonResponse = Gson().toJson(ErrorResponse(responseCode, errorBody))
                    println(jsonResponse)
                } else {
                    println("Response not successful. Response code: $responseCode")
                }
            }

        }

        override fun onFailure(call: Call<List<RepositoryItem>>, t: Throwable) {
            t.printStackTrace()
        }

    })


}