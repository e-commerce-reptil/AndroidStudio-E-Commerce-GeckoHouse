package SH.myapplication.Fragments

import SH.myapplication.CetakQrActivity
import SH.myapplication.R
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_akun.*
import kotlinx.android.synthetic.main.fragment_akun.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AkunFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private lateinit var rootView: View
//    private lateinit var appDb: AppDb
//    private var utils: Utils = Utils()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_akun, container, false)
        view.TvQrcode.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        // Inflate the layout for this fragment
        return view
    }
//
//    companion object {
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            AkunFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

//
//        val user_name = utils.getUser(appDb).fname + " " + utils.getUser(appDb).lname
//        name.text = user_name
//
//        item2.setOnClickListener {
//            Toast.makeText(rootView.context, "Coming Soon!!", Toast.LENGTH_LONG).show()
//        }
//
//        item3.setOnClickListener {
//            val intent = Intent(rootView.context, EditProfile::class.java)
//            intent.putExtra("flag", "logout")
//            rootView.context.startActivity(intent)
//        }
    }