# Build
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
COPY angular.json ./
COPY tsconfig*.json ./
COPY postcss.config.js ./
COPY proxy.conf.json ./
COPY src ./src
RUN npm install
RUN npm run build

# Execução
FROM nginx:alpine
WORKDIR /etc/nginx
RUN apk add --no-cache gettext
COPY docker/nginx.conf /etc/nginx/nginx.conf.template
COPY --from=build /app/dist/app/browser /usr/share/nginx/html
ENV API_URL="http://host.docker.internal:8501/api/"
CMD envsubst '$API_URL' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf && nginx -g 'daemon off;'
EXPOSE 80
