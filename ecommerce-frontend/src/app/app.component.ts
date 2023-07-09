import { Component } from '@angular/core';
import { ProductCategory } from './model/product-category';
import { ProductCategoryService } from './services/product-category.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ecommerce-frontend';

  productCategory:ProductCategory[]=[];

  constructor(private productCategoryService:ProductCategoryService){}

  ngOnInit(){
   this.listCategories();
  }

  private listCategories(){
    this.productCategoryService.getProductCategoryList().subscribe(
      data=>{
        console.log(data);
        this.productCategory=data;
      }
    );
  }
}
