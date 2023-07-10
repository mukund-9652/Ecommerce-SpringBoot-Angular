import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  constructor(private router: Router) { }

  doSearch(value: string) {
    if (value.length === 0) {
      this.router.navigateByUrl(`/products`);
    }
    else {
      this.router.navigateByUrl(`/search/${value}`);
    }
  }
}
