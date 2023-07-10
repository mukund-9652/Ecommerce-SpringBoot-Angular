import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  title='';
  constructor(private router: ActivatedRoute, private productService:ProductService) { }
  product!: Product;
  ngOnInit() {
    this.getProductDetails(parseInt(this.router.snapshot.paramMap.get('id')!));
  }
  getProductDetails(id:number){
    this.productService.getProduct(id).subscribe(
      data=>{
        this.title=data.id;
        this.product=data;
      }
    );
  }
}
