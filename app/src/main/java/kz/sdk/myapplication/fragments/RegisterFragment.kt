package kz.sdk.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kz.sdk.myapplication.databinding.FragmentLoginBinding
import kz.sdk.myapplication.databinding.FragmentProductDetailsBinding
import kz.sdk.myapplication.databinding.FragmentRegisterBinding

class RegisterFragment:Fragment() {


    private lateinit var binding: FragmentRegisterBinding

    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            if(binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString().isNotEmpty()){
                auth.createUserWithEmailAndPassword(binding.etEmail.text.toString(), binding.etPassword.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(requireContext(), "Account created", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

}