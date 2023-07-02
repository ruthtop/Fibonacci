FROM node:14-alpine
# Set working directory
WORKDIR /app
# Copy all files
COPY . .
# Install dependencies and production-ready assets
RUN npm install
RUN npm run build
# Expose port 3000
EXPOSE 3000
# Run application when container starts
CMD npm start --port=$PORT

