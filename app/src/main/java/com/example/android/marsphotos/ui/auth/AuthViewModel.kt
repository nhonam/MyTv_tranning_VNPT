package com.example.android.marsphotos.ui.auth


import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.data.db.entities.User
import com.example.android.marsphotos.data.repository.UserRepository
import com.example.android.marsphotos.util.ApiExceptions
import com.example.android.marsphotos.util.Coroutines
import com.example.android.marsphotos.util.LoadingCustom
import com.google.gson.JsonObject


class AuthViewModel :  ViewModel(){

    var email:String ? = null
    var password:String? = null
    var authListener : AuthListener? = null
    private val userRepository: UserRepository = UserRepository( )



     fun onButtonLoginClick() {

        authListener?.onStarted()


        var logginResponse : String? = null


        val params = HashMap<String, String>();
        params["device_model"] = "sdk_google_atv64_amati_arm64"
        params["fk"] = "first#key"
        params["device_type"] = "9"
        params["version_number"] = "470"
        params["password"] = "c4ca4238a0b923820dcc509a6f75849b"
        params["authen_type"] = "2"
        params["manufacturer_id"] = "7046fc86f010cba1"
        params["device_manu"] = "Google"
        params["app_hash"] = "b57a114216395fbb0909acf4bc49f497"
        params["username"] = "tsna90"

         Coroutines.main {
             try {
                 val loginResponse = UserRepository().userLogin(params)
                 val body:JsonObject = loginResponse?.get("response") as JsonObject
                 val user = User(
                     member_id = body.get("member_id").toString(),
                     product_id = body.get("product_id").toString(),
                     area_code = body.get("area_code").toString(),
                     username_mytv = body.get("username_mytv").toString(),
                     user_team_id = body.get("user_team_id").toString(),
                     user_type = body.get("user_type").toString(),
                     manufacturer_id = body.get("manufacturer_id").toString(),
                     product_plugin = body.get("product_plugin").toString()
                 )
                 authListener?.onSuccess(user)
             }catch (e: ApiExceptions) {
                 authListener?.onFailure(e.message!!)
             }


         }

    }
}