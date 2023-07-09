import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Product } from '../model/product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8081/api/products'
  constructor(private httpClient: HttpClient) { }
  
  getProductList(theCategoryId: number): Observable<Product[]> {
    const searchUrl= `${this.baseUrl}/category:${theCategoryId}`
    return this.httpClient.get<any[]>(searchUrl);
  }
}
