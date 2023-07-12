import { Component, Inject } from '@angular/core';
import { OKTA_AUTH, OktaAuthStateService } from '@okta/okta-angular';
import { OktaAuth } from '@okta/okta-auth-js';
import '@angular/compiler';

@Component({
  selector: 'app-login-status',
  templateUrl: './login-status.component.html',
  styleUrls: ['./login-status.component.css']
})
export class LoginStatusComponent {
  isAuth:boolean = false;
  userFullName:string='';

  constructor(private oktaAuthService: OktaAuthStateService,
    @Inject(OKTA_AUTH) private oktaAuth:OktaAuth){}

  ngOnInit(){
    this.oktaAuthService.authState$.subscribe(
      (result)=>{
        this.isAuth=result.isAuthenticated!;
        this.getUserDetails();
      }
    )
  }
  getUserDetails() {
    if(this.isAuth){
      this.oktaAuth.getUser().then(
        (res)=>{
          this.userFullName=res.name as string;
        }
      )
    }
  }

  logout(){
    this.oktaAuth.signOut();
  }
}
