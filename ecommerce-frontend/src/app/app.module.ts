import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http'
import { ProductService } from './services/product.service';
import { SearchComponent } from './components/search/search.component';
import { ProductDetailsComponent } from './component/product-details/product-details.component';
import { CartStatusComponent } from './component/cart-status/cart-status.component';
import { CartDetailsComponent } from './component/cart-details/cart-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
