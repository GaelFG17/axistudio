import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importa FormsModule
import { HttpClientModule, HttpClient } from '@angular/common/http'; // Importa HttpClientModule
import { Router } from '@angular/router';
import * as CryptoJS from 'crypto-js';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, FormsModule, HttpClientModule] // Asegúrate de incluir FormsModule y HttpClientModule
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  private secretKey: string = 'axs-lg4523679076'; // Clave compartida

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    // Encripta la contraseña usando AES con CryptoJS
    const encryptedPassword = CryptoJS.AES.encrypt(this.password, CryptoJS.enc.Utf8.parse(this.secretKey), {
      mode: CryptoJS.mode.ECB, // Asegúrate de usar el mismo modo en el backend
      padding: CryptoJS.pad.Pkcs7
    }).toString();

    const loginData = {
      email: this.username,
      password: encryptedPassword,
    };

    const headers = { 'Content-Type': 'application/json' };

    this.http.post('http://localhost:8080/customer/login', loginData, { headers }).subscribe(
      (response) => {
        console.log('Login successful:', response);
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        console.error('Login failed:', error);
        this.errorMessage = 'Usuario o contraseña incorrectos';
      }
    );
  }
}
