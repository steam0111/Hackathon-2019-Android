package com.itrocket.hackaton.ui.fragment.auth

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.extension.HintAdapter
import com.itrocket.hackaton.extension.findNavController
import com.itrocket.hackaton.presentation.presenter.auth.RegistrationPresenter
import com.itrocket.hackaton.presentation.view.auth.RegistrationView
import com.itrocket.hackaton.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : BaseFragment(), RegistrationView {
    companion object {
        const val TAG = "RegistrationFragment"
    }

    override val layoutResId = R.layout.fragment_registration

    @InjectPresenter
    lateinit var registrationPresenter: RegistrationPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnReg.setOnClickListener {
            registrationPresenter.btnRegClick(
                etEmail.text.toString(),
                etFirstname.text.toString(),
                etSecondName.text.toString(),
                etLastName.text.toString(),
                etPassword.text.toString()
            )
        }
    }

    override fun onShowUniversities(names: List<String>) {
        val arrayWithHint = Array(names.size + 1, init = {
            if (it == names.size) {
                getString(R.string.choose_university)
            } else {
                names[it]
            }
        })

        val hintAdapter = HintAdapter(
            this.context,
            R.layout.item_drop_down_menu_reg,
            arrayWithHint)

        spinnerUniversities.adapter = hintAdapter

        spinnerUniversities.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != arrayWithHint.lastIndex) {
                    registrationPresenter.onUniversityChange(position)
                }
            }
        }

        spinnerUniversities.setSelection(hintAdapter.count)
    }

    override fun onShowHome() {
        findNavController().navigate(R.id.action_registrationFragment_to_mainFragment)
    }

}