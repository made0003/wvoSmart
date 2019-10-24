package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wvoz.designsprint.databinding.MedicatieFragmentBinding

class MedicatieFragment : Fragment() {

    private var title: String? = null
    private var message: String? = null
    private var finalScreen: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            title = requireContext().getString(getInt("title"))
            message = requireContext().getString(getInt("message"))
            finalScreen = getBoolean("finalScreen")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = MedicatieFragmentBinding.inflate(inflater, container, false)
        binding.medicatieTitle = title
        binding.medicatieMessage = message
        binding.isFinalScreen = finalScreen

        binding.finalScreen.setOnClickListener {
            val i = Intent(requireActivity(), AgendaActivity::class.java)
            startActivity(i)
        }

        return binding.root
    }

    companion object {

        fun newInstance(@StringRes titleId: Int = R.string.medicijn_1, @StringRes messageId: Int=  R.string.medicijn_beschrijving_1, finalScreen : Boolean = false): MedicatieFragment {
            val args = Bundle()
            val fragment = MedicatieFragment()
            args.putInt("title", titleId)
            args.putInt("message", messageId)
            args.putBoolean("finalScreen", finalScreen)

            fragment.arguments = args
            return fragment
        }
    }

}