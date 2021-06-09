package SH.myapplication.Fragments

import SH.myapplication.databinding.FragmentUtamaBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class UtamaFragment : Fragment() {

    private lateinit var utamaViewModel: UtamaViewModel
    private var _binding: FragmentUtamaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        utamaViewModel =
            ViewModelProvider(this).get(UtamaViewModel::class.java)

        _binding = FragmentUtamaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textUtama
        utamaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}