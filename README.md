# Azure AD Demo Projects

This repository contains **two projects** that demonstrate how to integrate applications with **Azure Active Directory (Azure AD)** for authentication and authorization.  
Both projects are based on the same principle of using OAuth 2.0 / OpenID Connect flows but differ slightly in implementation.

---

## Projects in This Repository

### 1. OAuth2 Demo Application
- A simple demonstration of how to integrate an application with Azure AD using **OAuth 2.0**.
- Useful as a reference for understanding the authentication flow and token handling.
- Shows how to request user sign-in, obtain access tokens, and call protected APIs.

### 2. Azure Starter with Active Directory Library
- A starter project that uses the **azure-starter-active-directory** library.
- Provides a more opinionated setup with built-in helpers for authentication and authorization.
- Designed to help kickstart new applications with less manual configuration.

---

## Configuration

Both projects require configuration with your **Azure AD application credentials**.

To fill in the properties (such as `clientId`, `tenantId`, `clientSecret`, and `redirectUri`):

1. Go to **PIM**.
2. Retrieve the necessary credentials for the Azure AD application.
3. Update the configuration files in each project with these values.

Typical properties you need to configure:
- **Client ID (Application ID)**
- **Client Secret**
- **Tenant (Directory) ID**
- **Redirect URI(s)**
- **Groups** 

---

## How They Differ

- **OAuth2 Demo App**:  
  Minimalistic, shows raw OAuth2/OpenID Connect integration flow.

- **Azure Starter AD Library Project**:  
  Abstracts away some complexity by using the `azure-starter-active-directory` library.

Both ultimately achieve the same goal: **authenticate users with Azure AD and issue tokens for accessing secured resources**.

---

## Notes

- Use these projects as learning tools or starting points for integrating your own applications with Azure AD.
- If you require a new Azure AD application, use the [Azure AD Application Request Template](./Azure_AD_Application_Request_Template.md) included in this repository and make a ticket via horizon or your internal devops team.

---
