package com.example.nhahang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ChiTietMonFramgent : DialogFragment() {
    private lateinit var btnSua : Button
    private lateinit var btnXoa : Button
    override fun onStart(){
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.framgent_chi_tiet_mon, container, false)
    }
    override fun onViewCreated(view : View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSua = view.findViewById(R.id.btnXacNhanSua)
        btnXoa = view.findViewById(R.id.btnXoaMon)
        btnSua.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(),"Sửa món thành công",Toast.LENGTH_SHORT).show()
        }
        btnXoa.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(),"Xóa món thành công",Toast.LENGTH_SHORT).show()
        }
    }
//    //set control
//    fun setControl(){
//        btnThem = findViewById()
//    }


}