package com.sobuy.pda.feature.my.ui.fragment

import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.sobuy.pda.R
import com.sobuy.pda.databinding.FragmentDialogExitBinding
import com.sobuy.pda.core.base.fragment.BaseViewModelDialogFragment
import com.sobuy.pda.core.utils.SuperProcessUtil
import com.sobuy.pda.core.utils.ScreenUtil

class ExitDialogFragment :
    BaseViewModelDialogFragment<FragmentDialogExitBinding>(FragmentDialogExitBinding::inflate) {
    private lateinit var onAgreementClickListener: OnClickListener

    override fun initViews() {
        super.initViews()
//        isCancelable = true
//        dialog!!.window!!.setBackgroundDrawableResource(R.drawable.dialog_rounded_bg)
    }

    override fun initDatum() {}

    override fun initListeners() {
        super.initListeners()
        binding.yes.setOnClickListener {
            onAgreementClickListener.onClick(it)
            dismiss()
            SuperProcessUtil.killApp()
        }
        binding.cancel.setOnClickListener {
//            dismiss()
//            SuperProcessUtil.killApp()
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.apply {
            isCancelable = false
            setBackgroundDrawableResource(R.drawable.dialog_rounded_bg)
            setLayout(
                ((ScreenUtil.getScreenWidth(requireContext()) * 0.65).toInt()),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    companion object {
        fun show(fragmentManager: FragmentManager, onAgreementClickListener: OnClickListener) {
            val dialogFragment = ExitDialogFragment()
            dialogFragment.onAgreementClickListener = onAgreementClickListener;
            dialogFragment.show(fragmentManager, "ExitDialogFragment")
        }

        const val TAG = "ExitDialogFragment"

    }

}