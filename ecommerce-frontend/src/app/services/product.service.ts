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

  getProductForSearch(searchMessage:string): Observable<Product[]> {
    searchMessage=searchMessage.replace(' ','+')
    const searchUrl = `${this.baseUrl}/search:${searchMessage}`
    return this.httpClient.get<any[]>(searchUrl);
  }

  getProduct(id:number){
    const getUrl=`${this.baseUrl}/id:${id}`;
    return this.httpClient.get<any>(getUrl);
  }

  getProductList(theCategoryId: number): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}/category:${theCategoryId}`
    return this.httpClient.get<any[]>(searchUrl);
  }
  getAllProductList(): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}`
    return this.httpClient.get<any[]>(searchUrl);
  }
}
