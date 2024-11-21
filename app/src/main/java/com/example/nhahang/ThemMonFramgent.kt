package com.example.nhahang

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ThemMonFramgent : DialogFragment() {
    private lateinit var btnThem : Button

    override fun onStart(){
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.framgent_them_mon, container, false)
    }
    override fun onViewCreated(view : View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnThem = view.findViewById(R.id.btnThem)
        btnThem.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(),"Thêm món thành công",Toast.LENGTH_SHORT).show()
        }
    }
//    //set control
//    fun setControl(){
//        btnThem = findViewById()
//    }


}