# Build
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
COPY angular.json ./
COPY src ./src
RUN npm install
RUN npm run build -- --output-path=dist

# Execução
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY docker/nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
