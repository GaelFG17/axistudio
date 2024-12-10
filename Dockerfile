# Etapa 1: Construcción de Angular
FROM node:18-alpine as build
WORKDIR /app
COPY package*.json ./

# Instalar dependencias incluyendo Angular CLI globalmente
RUN npm install -g @angular/cli && npm install

COPY . .
RUN ng build --configuration production

# Etapa 2: Configuración de Nginx
FROM nginx:alpine
COPY --from=build /app/dist/login/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
