package com.aliakberaakash.thirtydayschallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aliakberaakash.thirtydayschallenge.R

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.my_bottom_sheet.*

class BottomSheetDialog(val callBack : BottomSheetCallBack) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.my_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_button.setOnClickListener {
            val title = title_text_field.text.toString()
            callBack.onSavedButtonClicked(title)
        }

    }
}