//package SH.myapplication.SignInUp
//
//import SH.myapplication.All.apiToken
//import SH.myapplication.All.clearFocusableAllEditText
//import SH.myapplication.All.removeResponseRegex
//import SH.myapplication.All.resetErrorEdittext
//import SH.myapplication.DataClass.UserInfo
//import SH.myapplication.MainActivity
//import SH.myapplication.R
//import SH.myapplication.SettingsAPI.Interface.UserInterface
//import SH.myapplication.SettingsAPI.ResponseDataClass.ErrorHelper
//import SH.myapplication.SettingsAPI.ResponseDataClass.ErrorResponse
//import SH.myapplication.SettingsAPI.ServerAPI
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import kotlinx.android.synthetic.main.activity_sign_in_up.*
//import kotlinx.android.synthetic.main.fragment_sign_in.view.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
//class SignInFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//
//        //TODO : if remember me is clicked, then save user email into database. if login success, save its apiToken too
//        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
//        val input_email = view.signin_input_email
//        val input_password = view.signin_input_password
//        val txt_signUp = view.signin_txtClick_signUp
//        val btn_signIn = view.signin_btn_signIn
//
//        resetErrorEdittext(view.signin_layout_email, input_email)
//        resetErrorEdittext(view.signin_layout_password, input_password)
//
//
//        txt_signUp.setOnClickListener {
//            nav_host_fragment.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
//        }
//
//        btn_signIn.setOnClickListener {
//            clearFocusableAllEditText(arrayListOf(input_email, input_password))
//            if(input_email.text.toString().isNotEmpty() && input_password.text.toString().isNotEmpty()){
//                val userInfo = UserInfo(
//                        userEmail = input_email.text.toString(),
//                        userPassword = input_password.text.toString()
//                )
//
//                val loadingBar = activity?.signinup_progress
//                loadingBar!!.visibility = View.VISIBLE
//                val userInterface : UserInterface = ServerAPI().getServerAPI()!!.create(UserInterface::class.java)
//                userInterface.userLogin(userInfo).enqueue(object : Callback<UserInfo> {
//                    override fun onResponse(call: Call<UserInfo>?, response: Response<UserInfo>?) =
//                            if (response!!.isSuccessful) {
//                                loadingBar!!.visibility = View.GONE
//                                apiToken = response.body()?.userAPItoken!!
//                                Toast.makeText(activity, "Login successfull.", Toast.LENGTH_LONG).show()
//                                val intent = Intent(activity, MainActivity::class.java)
//                                startActivity(intent)
//                            } else {
//                                loadingBar!!.visibility = View.GONE
//                                try {
//                                    val output : ErrorResponse = ErrorHelper().parseErrorBody(response)
//                                    view.signin_layout_email.error =
//                                            if (output.errors?.email.toString() != "null")
//                                            {removeResponseRegex(output.errors?.email.toString())}
//                                            else{null}
//                                    view.signin_layout_password.error =
//                                            if (output.errors?.password.toString() != "null")
//                                            {removeResponseRegex(output.errors?.password.toString())}
//                                            else{null}
//                                } catch (e: Exception) {}
//                            }
//
//                    override fun onFailure(call: Call<UserInfo>?, t: Throwable) {
//                        Toast.makeText(activity, t.toString(), Toast.LENGTH_SHORT).show()
//                        Log.d("failure", t.toString())
//                    }
//                })
//            }
//            else{
//                if(input_email.text.toString().isEmpty()){
//                    view.signin_layout_email.error = "Email cannot be null or empty."
//                }
//                if(input_password.text.toString().isEmpty()){
//                    view.signin_layout_password.error = "Password cannot be null or empty."
//                }
//            }
//        }
//
//
//
//        return view
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            SignInFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//
//}