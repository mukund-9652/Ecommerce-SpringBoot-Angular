import { Injectable } from '@angular/core';
import { CartItem } from '../model/cart-item';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  
  totalPrice: Subject<number> = new Subject<number>;
  totalQuantity: Subject<number> = new Subject<number>;
  
  constructor() { }
  
  removeCartItem(cartItem: CartItem) {
    let existInCart: boolean = false;
    let existingInCartIndex!: number;

    if (this.cartItems.length > 0) {
      for(let i=0;i<this.cartItems.length;i++){
        if(this.cartItems[i].id===cartItem.id){
          existInCart = true;
          existingInCartIndex=i;
          break;
        }
      }
    }

    if (existInCart) {
      //console.log(existingInCart);
      this.cartItems.splice(existingInCartIndex,1)
    }  
  }
  addToCart(cartItem: CartItem) {
    let existInCart: boolean = false;
    let existingInCart!: CartItem;

    if (this.cartItems.length > 0) {
      for(let i=0;i<this.cartItems.length;i++){
        if(this.cartItems[i].id===cartItem.id){
          existingInCart=this.cartItems[i];
          break;
        }
      }
      existInCart = (existingInCart != undefined);
    }

    if (existInCart) {
      //console.log(existingInCart);
      existingInCart.quantity++;
    }
    else {
      this.cartItems.push(cartItem);
    }
    this.computeCartTotal();
  }
  computeCartTotal() {
    let totalPriceValue = 0;
    let totalQuantityValue = 0;
    this.cartItems.forEach(item => {
      totalPriceValue += item.unitPrice * item.quantity;
      totalQuantityValue += item.quantity;
    });
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    //this.logCartData(totalPriceValue, totalQuantityValue);
  }

  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log("Contents of Cart");
    this.cartItems.forEach(item => {
      console.log(item.name);
    })
    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}`);
    console.log('----------')
  }

}
