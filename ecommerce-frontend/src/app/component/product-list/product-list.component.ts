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
  
  products: Product[] = [];
  currentCategoryId: number = 1;
  searchMode: boolean = false;
  searchMessage: string = "";

  constructor(private productService: ProductService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
    this.currentCategoryId = 1;
    this.searchMode = false;
    this.searchMessage=  "";
  }

  private listProducts() {

    this.searchMode = this.route.snapshot.paramMap.has('searchMessage');
    if (this.searchMode) {
      this.handleSearchProducts();
    }
    else {
      this.handleListProducts();
    }
  }

  handleSearchProducts() {
    const keyWord: string = this.route.snapshot.paramMap.get('searchMessage')!;
    this.productService.getProductForSearch(keyWord).subscribe(
      data => {
        if (data.length > 0) {
          this.products = data;
        }
        else{
          this.searchMessage= `No Product of ${keyWord} Found!!`
        }
      }
    );
  }

  handleListProducts() {
    //check if id param is available

    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      //get the 'id' param string and convert it to number

      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      this.productService.getProductList(this.currentCategoryId).subscribe(
        data => {
          this.products = data;
        }
      );
    }
    else {
      // setting default catgory 1
      this.productService.getAllProductList().subscribe(
        data => {
          const jumbledData = data.sort(() => Math.random() - 0.8);
          this.products = jumbledData;
        }
      );
    }
  }
}
