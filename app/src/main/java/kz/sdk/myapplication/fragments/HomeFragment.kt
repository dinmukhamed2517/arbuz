package kz.sdk.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.sdk.myapplication.Adapter
import kz.sdk.myapplication.Product
import kz.sdk.myapplication.R
import kz.sdk.myapplication.databinding.FragmentHomeBinding

class HomeFragment:Fragment() {


    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = Adapter()

        val adapter1 = Adapter()

        binding.recycler2.adapter = adapter1
        binding.recycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        adapter.click = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToProductDetailsFragment(it))
        }
        adapter1.click = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToProductDetailsFragment(it))
        }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(getList())
        adapter1.submitList(getList2())
    }

    fun getList():List<Product>{
        return listOf(
            Product(1, "Кола", R.drawable.product_1, 490, "Coca-cola самый популярный газированный напиток в мире. Имеет резкий, но приятный вкус, хорошо утоляет жажду, рекомендуется пить охлажденным."),
            Product(2, "Спрайт", R.drawable.product_2, 500, "Sprite — cильногазированный напиток со вкусом лимона и лайма отлично освежает и вкусно утоляет жажду. Зарядись позитивной и вкусной цитрусовой энергией на целый день!."),
            Product(3, "Курица", R.drawable.product_3, 3000, "Это наша курица шоковой заморзки. Натуральная фермерская курица."),
            Product(4, "Апельсин", R.drawable.product_4, 300, "Апельсины едят не только свежими, из них готовят соки и компоты, джемы, варенья, желе и мармелады, цедру апельсина используют для приготовления десертов, салатов и для придания пикантности мясным блюдам."),
        )
    }
    fun getList2():List<Product>{
        return listOf(
            Product(5, "Голубика от Arbuz Select", R.drawable.product_5, 1923, "Ягода выращенная на плантациях и в теплицах Казахстана, с соблюдением всех экологических стандартов.\n" +
                    "Ягоды голубики содержат витамины В1, В2, РР, С, А, Р, кальций, фосфор, железо, фенольные соединения, органические сахара и кислоты, клетчатку, дубильные, красящие и пектиновые вещества."),
            Product(6, "Хлеб Arbuz Select пшеничный домашний 400 г", R.drawable.product_6, 500, "Наш домашний пшеничный хлеб - имеет плотную, хрустящую корочку и мягкий, пористый, воздушный мякиш. Ремесленный хлеб формуется вручную и выпекается в подовой печи на камнях."),
            Product(3, "Курица", R.drawable.product_3, 3000, "Это наша курица шоковой заморзки. Натуральная фермерская курица."),
            Product(4, "Апельсин", R.drawable.product_4, 300, "Апельсины едят не только свежими, из них готовят соки и компоты, джемы, варенья, желе и мармелады, цедру апельсина используют для приготовления десертов, салатов и для придания пикантности мясным блюдам."),
        )
    }
}