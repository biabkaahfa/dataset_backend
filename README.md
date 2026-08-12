# Dataset Backend — API REST de Gestion & d'Expérimentation ML

**Dépôt Backend Officiel :** https://github.com/biabkaahfa/dataset_backend  
**Dépôt Frontend Officiel :** https://github.com/ao627515/dataset_frontend

> Projet réalisé dans le cadre du **Master Intelligence Artificielle — Devoir Pratique Spring Boot & Angular (2026/2027)**

API REST robuste développée en **Spring Boot 4.1** (Java 21) permettant aux chercheurs d'un laboratoire de cataloguer leurs datasets, modèles ML et de suivre leurs expérimentations.

---

## Contexte du Projet

Un laboratoire de recherche souhaite disposer d'un outil interne permettant à ses chercheurs de :

- 📂 **Cataloguer les jeux de données (datasets)** : Formats (CSV, JSON, Parquet, Image, Text), nombre d'observations, sources et descriptions.
- 🤖 **Cataloguer les modèles de Machine Learning** : Algorithmes (Random Forest, XGBoost, SVM, ResNet, Transformer...), types (Classification, Régression, Deep Learning...) et versions.
- 📊 **Suivre et comparer les expérimentations** : Associer un modèle ML à un dataset et tracer les métriques de performance (Accuracy, F1-Score, Durée d'entraînement).

---

## Prise en main Rapide (Installation & Lancement)

### 1. Prérequis

| Outil | Version minimale |
|-------|-----------------|
| Java  | 21              |
| Maven | 3.9+            |

### 2. Cloner & Lancer

```bash
# 1. Cloner le projet
git clone https://github.com/biabkaahfa/dataset_backend.git
cd dataset_backend

# 2. Lancer le serveur (télécharge les dépendances et démarre)
./mvnw spring-boot:run
```

| URL | Description |
|-----|-------------|
| `http://localhost:8080` | API REST |
| `http://localhost:8080/swagger-ui/index.html` | Documentation interactive Swagger UI |
| `http://localhost:8080/h2-console` | Console H2 (base en mémoire) |

> **Note :** Pour une utilisation complète avec le frontend Angular, assurez-vous que le projet [dataset_frontend](https://github.com/ao627515/dataset_frontend) tourne sur le port **4200**.

---


## Architecture & Concepts Backend

L'application repose sur une **architecture en couches** avec des abstractions génériques réutilisables suivant le pattern **Template Method** :

```
src/main/java/com/example/dataset/
├── config/                     # Configuration globale
│   ├── CorsConfig.java         # CORS (autorise localhost:4200)
│   └── SwaggerConfig.java      # Documentation OpenAPI
├── common/                     # Abstractions génériques réutilisables
│   ├── controller/             # GenericController<T, D, ID> — CRUD mutualisé
│   ├── service/                # GenericService<T, ID>        — Logique métier
│   ├── repository/             # GenericRepository<T, ID>     — Accès données
│   ├── mapper/                 # GenericMapper<T, D>          — Entité ↔ DTO
│   └── dto/                    # ApiResponse<T>               — Enveloppe standardisée
├── controller/                 # Contrôleurs spécifiques (Dataset, ModeleML, Experimentation)
├── service/                    # Services spécifiques
├── repository/                 # Repositories JPA spécifiques
├── mapper/                     # Mappers MapStruct spécifiques
├── domain/
│   ├── entity/                 # Entités JPA (Dataset, ModeleML, Experimentation)
│   └── dto/                    # DTOs avec validations Bean Validation
└── exception/
    └── GlobalExceptionHandler  # @RestControllerAdvice — Gestion centralisée des erreurs
```

---

## Stack Technique

| Catégorie | Technologie | Version |
|-----------|-------------|---------|
| Framework | Spring Boot | 4.1.0 |
| Langage | Java | 21 |
| Persistance | Spring Data JPA + H2 | — |
| Validation | Jakarta Bean Validation | — |
| Mapping | MapStruct | 1.5.5 |
| Réduction du code | Lombok | — |
| Documentation API | SpringDoc OpenAPI (Swagger) | 3.1.0 |
| Build | Maven | 3.9+ |

---

## Connexion Frontend

**Dépôt Frontend GitHub :** https://github.com/ao627515/dataset_frontend

Application web moderne développée en **Angular 21** et **PrimeNG v21**. Elle consomme cette API REST et offre :
- Un tableau de bord analytique avec graphiques Chart.js
- La gestion complète des datasets, modèles ML et expérimentations
- Une protection contre la suppression de ressources liées à des expérimentations actives
- Des formulaires réactifs avec validations d'intervalles strictes (Accuracy et F1-Score entre 0.00 et 1.00)
