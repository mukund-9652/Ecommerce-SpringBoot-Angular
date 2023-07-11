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
  constructor(private cartService:CartService){}
  ngOnInit(){
    this.getCartItems();
  }
  getCartItems() {
    this.cartItems=this.cartService.cartItems;
    console.log(this.cartItems)
  }
}
