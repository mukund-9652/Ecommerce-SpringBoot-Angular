import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  products: Product[] =[];
  currentCategoryId: number=1;

  constructor(private productService:ProductService,
              private route:ActivatedRoute){}

  ngOnInit():void{
    this.route.paramMap.subscribe(() =>{
      this.listProducts();
    });
  }

  private listProducts() {

    //check if id param is available

    const hasCategoryId:boolean=this.route.snapshot.paramMap.has('id');

    if(hasCategoryId){
      //get the 'id' param string and convert it to number

      this.currentCategoryId= +this.route.snapshot.paramMap.get('id')!;
    }
    else{
      // setting default catgory 1
      this.currentCategoryId=1;
    }

    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products=data;
      }
    );
  }
}
