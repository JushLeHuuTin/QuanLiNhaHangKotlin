package com.example.nhahang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ChiTietMonFramgent : DialogFragment() {
    private lateinit var btnSua : Button
    private lateinit var btnXoa : Button
    private lateinit var imgMon : ImageView
    private var imgMonInt : Int = 0
    override fun onStart(){
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imgMonInt = it.getInt("imgMon")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.framgent_chi_tiet_mon, container, false)
    }
    override fun onViewCreated(view : View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setControl(view)

        setEvent()
    }
    companion object {
        // Factory method để truyền dữ liệu vào Fragment
        fun newInstance(imgMon: Int): ChiTietMonFramgent {
            val fragment = ChiTietMonFramgent()
            val args = Bundle()
            args.putInt("imgMon", imgMon)
            fragment.arguments = args
            return fragment
        }
    }
    //set control
    fun setControl(view :View){
    imgMon = view.findViewById(R.id.imgMon)
    btnSua = view.findViewById(R.id.btnXacNhanSua)
    btnXoa = view.findViewById(R.id.btnXoaMon)
    imgMon.setBackgroundResource(imgMonInt)
    }
    //set event
    fun setEvent(){
        btnSua.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(),"Sửa món thành công",Toast.LENGTH_SHORT).show()
        }
        btnXoa.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(),"Xóa món thành công",Toast.LENGTH_SHORT).show()
        }
    }

}