package kz.sdk.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sdk.myapplication.databinding.FragmentCartBinding
import kz.sdk.myapplication.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment:Fragment() {


    private lateinit var binding: FragmentProductDetailsBinding
    private val args : ProductDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.image.setImageResource(args.product.img)
        binding.title.text = args.product.name
        binding.price.text = "${args.product.price} ₸"
        binding.description.text = args.product.description
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}