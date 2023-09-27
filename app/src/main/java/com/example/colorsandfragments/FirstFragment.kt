package com.example.colorsandfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener


class FirstFragment : Fragment() {

    private var colorState = ColorState(0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorSquare: View = view.findViewById(R.id.color_square)
        val toSecondBut: Button = view.findViewById(R.id.to_secont_btn)

        setFragmentResultListener("requestKey2") { requestKey, bundle ->
            recieveResult(bundle, colorSquare)
        }

        updateColor(colorSquare)

        toSecondBut.setOnClickListener {

            val fragment2 = SecondFragment.newInstance(colorState)
            parentFragmentManager.beginTransaction().replace(R.id.first_container, fragment2)
                .commit()
        }
    }

    private fun recieveResult(bundle: Bundle, colorSquare: View) {
        val result: ColorState? = bundle.getParcelable("bundleKey2")
        if (result != null) {
            colorState = result
            updateColor(colorSquare)
        }
    }

    private fun updateColor(view: View) {
        if (colorState.colorCount == 0) {
            view.setBackgroundColor(Color.parseColor("#ffffff"))
        } else if (colorState.colorCount == 1) {
            view.setBackgroundColor(Color.parseColor("#003499"))
        } else {
            view.setBackgroundColor(Color.parseColor("#700007"))
        }
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}