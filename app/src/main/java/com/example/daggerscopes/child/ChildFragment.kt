package com.example.daggerscopes.child

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.daggerscopes.*
import com.example.daggerscopes.di.ParentComponentFinder
import com.example.daggerscopes.di.common.scopedComponent
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_child.*

class ChildFragment : Fragment(R.layout.fragment_child) {

    private val argConstant: ChildConstant get() = requireArguments().getParcelable("ARG_CONST")!!

    val component: ChildComponent by scopedComponent {
        ParentComponentFinder.find(this).childComponent().create(argConstant)
    }

    private val viewModel: ChildViewModel by viewModels { component.viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_closeScope.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        textView_component.text = component.hashCode().toString(16)

        button_double.setOnClickListener { viewModel.double() }
        button_half.setOnClickListener { viewModel.half() }
    }

    companion object {
        fun newInstance(constant: ChildConstant) = ChildFragment().apply {
            arguments = bundleOf("ARG_CONST" to constant)
        }
    }
}

@Parcelize
data class ChildConstant(
    val constant: Int
) : Parcelable