import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductCategory } from '../model/product-category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {
  private baseUrl = 'http://localhost:8081/api/categories'
  constructor(private httpClient: HttpClient) { }
  
  getProductCategoryList(): Observable<ProductCategory[]> {
    return this.httpClient.get<any[]>(this.baseUrl);
  }
}
