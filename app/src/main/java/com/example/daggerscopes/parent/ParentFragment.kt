package com.example.daggerscopes.parent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.daggerscopes.*
import com.example.daggerscopes.child.ChildConstant
import com.example.daggerscopes.child.ChildFragment
import com.example.daggerscopes.di.AppComponentFinder
import com.example.daggerscopes.di.HasParentComponent
import com.example.daggerscopes.di.common.scopedComponent
import kotlinx.android.synthetic.main.fragment_parent.*

class ParentFragment : Fragment(R.layout.fragment_parent),
    HasParentComponent {

    override val component: ParentComponent by scopedComponent {
        AppComponentFinder.find(this).parentComponent()
    }

    private val viewModel: ParentViewModel by viewModels { component.viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_openScope.setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(
                    R.id.container_parent,
                    ChildFragment.newInstance(
                        ChildConstant(viewModel.number.value!!)))
                .addToBackStack(null)
                .commit()
        }

        viewModel.number.observe(this, Observer { textView.text = it.toString() })
        button_inc.setOnClickListener { viewModel.inc() }
        button_dec.setOnClickListener { viewModel.dec() }
    }
}

