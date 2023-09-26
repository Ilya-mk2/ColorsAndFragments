package com.example.colorsandfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.LifecycleOwner

class SecondFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var colorState = ColorState()

        setFragmentResultListener("requestKey") { requestKey, bundle ->

            var result : ColorState?= bundle.getParcelable("bundleKey")
            if (result != null) {
                colorState = result
            }
        }


        val changeColorBtn : Button = view.findViewById(R.id.change_color_btn)

        changeColorBtn.setOnClickListener {
            colorState.colorCount = (colorState.colorCount+1)%3
        }

        val toFirstBtn : Button = view.findViewById(R.id.to_first_btn)

        toFirstBtn.setOnClickListener {

            val result = colorState
            setFragmentResult("requestKey2", bundleOf("bundleKey2" to result))

            //parentFragmentManager.beginTransaction().remove(SecondFragment())
        }
    }

    companion object{

        fun newInstance() = SecondFragment()
    }
}