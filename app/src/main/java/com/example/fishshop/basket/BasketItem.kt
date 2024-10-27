package com.example.fishshop.basket

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.fishshop.product.Product

data class BasketItem(val product: Product, var quantity: Int) {
    val totalPrice: Double get() = product.price * quantity
    fun increaseQuantity() { quantity++ }
    fun decreaseQuantity() { if (quantity > 1) quantity-- }
}

class BasketViewModel : ViewModel() {
    private val _basketItems = mutableStateListOf<BasketItem>()
    val basketItems: SnapshotStateList<BasketItem> = _basketItems

    fun addToBasket(product: Product) {
        val existingItem = _basketItems.find { it.product.name == product.name }
        if (existingItem != null) {
            existingItem.increaseQuantity()
        } else {
            _basketItems.add(BasketItem(product, 1))
        }
    }

    fun removeFromBasket(product: Product) {
        _basketItems.removeAll { it.product.name == product.name }
    }

    fun getTotalPrice(): Double {
        return _basketItems.sumOf { it.totalPrice }
    }

    fun increaseQuantity(basketItem: BasketItem) {
        basketItem.increaseQuantity()
    }

    fun decreaseQuantity(basketItem: BasketItem) {
        basketItem.decreaseQuantity()
    }
}
