import { Component } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  products: Product[] =[];
  constructor(private productService:ProductService){}

  ngOnInit():void{
    this.listProducts();
  }

  private listProducts() {
    this.productService.getProductList().subscribe(
      data => {
        this.products=data;
      }
    );
  }
}