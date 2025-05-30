import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { provideAnimations } from '@angular/platform-browser/animations';
import { bootstrapApplication } from '@angular/platform-browser';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { FooterComponent } from './pages/footer/footer.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AuthComponent } from './pages/auth/auth.component';
import { AuthServiceService } from './services/Auth/auth-service.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [NavbarComponent, FooterComponent,HomePageComponent,AuthComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'recipe-sharing';

  user:any=null;
  
  constructor(public authService:AuthServiceService){}

   ngOnInit() {
    console.log("ngOnInit")
    this.authService.getUserProfile().subscribe({
      next:data=>console.log("ureq user",data),
      error:error=>console.log("error",error)
      

    });
    this.authService.authSubject.subscribe(
      (auth)=>{
        console.log("auth object valur", auth)
        this.user=auth.user
      }
    )
  }
}
