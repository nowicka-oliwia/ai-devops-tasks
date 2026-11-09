
# Pipeline CI/CD w Jenkinsie – diagram Mermaid

```mermaid
flowchart TD
    A([Start pipeline]) --> B[Checkout kodu z Git]
    B --> C[Budowanie aplikacji]
    C --> D[Testy jednostkowe]

    D --> E{Testy zaliczone?}
    E -- Nie --> X[Pipeline zakończony błędem]
    E -- Tak --> F[Analiza statyczna kodu]

    F --> G[Kontrola bezpieczeństwa]
    G --> H{Brak krytycznych problemów?}

    H -- Nie --> X
    H -- Tak --> I[Budowanie obrazu Docker]

    I --> J[Testy integracyjne]
    J --> K{Testy zaliczone?}

    K -- Nie --> X
    K -- Tak --> L[Wdrożenie na staging]

    L --> M[Testy akceptacyjne]
    M --> N{Akceptacja wdrożenia?}

    N -- Nie --> X
    N -- Tak --> O[Wdrożenie na produkcję]

    O --> P([Koniec pipeline])

    style A fill:#d1fae5,stroke:#059669,color:#000
    style P fill:#d1fae5,stroke:#059669,color:#000
    style X fill:#fee2e2,stroke:#dc2626,color:#000
    style O fill:#dbeafe,stroke:#2563eb,color:#000
```

## Opis diagramu

Diagram przedstawia automatyczny proces CI/CD
dla aplikacji webowej z wykorzystaniem Jenkinsa.

Pipeline rozpoczyna się od pobrania kodu
i kończy wdrożeniem aplikacji na produkcję.
