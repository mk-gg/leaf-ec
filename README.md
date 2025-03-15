# Leaf-Ecommerce

### Tech Stack:
- Backend: Java, Spring Boot, PostgreSQL (database)
- Frontend: Angular, Taildwind CSS, DaisyUI
- Auth and Payment: Kinde, Stripe

### Features:
- 🔨 Admin functionality ( add product & categories )
- 🔒 Kinde Authentication
- 💳 Stripe integration
- 🏦 Hexagonal architecture (Backend)


## How to run
### Requirements
- IntelliJ or VSCode
- Docker
- JDK
- Node.Js
- Angular CLI (I've used V18)

### Install the dependencies first

``npm install``

### Environment Configuration
Make sure to have a `.env` file ready in the `ecom-backend/` directory. This file must contain the following environment variables:
````
KINDE_CLIENT_ID=<client-id>
KINDE_CLIENT_SECRET=<client-secret>
STRIPE_API_KEY=<stripe-api-key>
STRIPE_WEBHOOK_SECRET=<stripe-webhook-secret>
````

## Frontend
To run the dev server for your app, use:

```sh
npx nx serve ecom-frontend
```

To create a production bundle:

```sh
npx nx build ecom-frontend
```

To see all available targets to run for a project, run:

```sh
npx nx show project ecom-frontend
```

## Backend
To run the dev server for your app, use:

```sh
npx nx serve ecom-backend
```

To create a production bundle:

```sh
npx nx build ecom-backend
```

To see all available targets to run for a project, run:

```sh
npx nx show project ecom-backend
```


