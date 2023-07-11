import { Component } from '@angular/core';
import { CartItem } from 'src/app/model/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent {
  cartItems:CartItem[]=[]
  totalPrice:number=0.00;
  totalQuantity: number=0
  constructor(private cartService:CartService){}
  ngOnInit(){
    this.getCartItems();
  }
  getCartItems() {
    this.cartItems=this.cartService.cartItems;
    
    this.cartService.totalPrice.subscribe(data=>{
      this.totalPrice=data;
    });
    this.cartService.totalQuantity.subscribe(data=>{
      this.totalQuantity=data;
    });
    //console.log(this.cartItems)
    this.cartService.computeCartTotal();
  }

  incrementQuantity(cartItem:CartItem){
    cartItem.quantity++;
    this.cartService.computeCartTotal();
  }
  decrementQuantity(cartItem:CartItem){
    if(cartItem.quantity>1){
      cartItem.quantity--;
      this.cartService.computeCartTotal();
    }
    else{
      this.cartService.removeCartItem(cartItem);
      this.cartService.computeCartTotal();
    }
  }

  removeCartItem(cartItem:CartItem){
    this.cartService.removeCartItem(cartItem);
    this.cartService.computeCartTotal();
  }
}
