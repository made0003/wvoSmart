package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wvoz.designsprint.databinding.ChecklistFragmentBinding

class ChecklistFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ChecklistFragmentBinding.inflate(inflater, container, false)
        binding.checklistTitle = title
        binding.checklistMessage = message
        binding.isFinalScreen = finalScreen

        binding.finalScreen.setOnClickListener {
            val i = Intent(requireActivity(), MedicatiePager::class.java)
            startActivity(i)
            requireActivity().finish()
        }

        return binding.root
    }

    companion object {

        fun newInstance(
            @StringRes titleId: Int = R.string.checklist_1, @StringRes messageId: Int = R.string.checklist_beschrijving_1,
            finalScreen: Boolean = false
        ): ChecklistFragment {
            val args = Bundle()
            val fragment = ChecklistFragment()
            args.putInt("title", titleId)
            args.putInt("message", messageId)
            args.putBoolean("finalScreen", finalScreen)

            fragment.arguments = args
            return fragment
        }
    }

}