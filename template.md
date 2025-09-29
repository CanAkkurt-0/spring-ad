# Azure AD Application Request Template

This README provides a reusable template for requesting the creation of an **Azure Active Directory (AAD) application**.  
Fill in the placeholders and submit it as an **email** or **ticket** to the Azure Admin / IT Team.

---

## Email / Ticket Content

**Subject:** Request for Azure AD Application Registration – `[Project/Team Name]`

---

### Greeting

Hello `[Azure Admin / IT Team]`,

I would like to request the creation of a new **Azure Active Directory (AAD) application** to support the **[Project/Team Name]** initiative.  
This application will be used for **authentication and authorization** with our systems.

---

### Purpose (check all that apply)

- [ ] Secure user authentication via Azure AD (OAuth2 / OpenID Connect)
- [ ] Enable authorization using roles, group claims, or AD claims
- [ ] Multi-environment support (Development / Staging / Production / Demo / Internal)

---

### Application Details

| Setting               | Value (fill in) |
|------------------------|-----------------|
| **Application Name**   | `[App Name]` |
| **Application Type**   | `[Web Application / SPA / API]` |
| **Redirect URI(s)**    | `[List URIs: dev, staging, prod]` |
| **Client Secret**      | `[Yes / No]` |
| **Permissions/Scopes** | `[OpenID, profile, email, Graph API, etc.]` |
| **Group Claims**       | `[Specific Groups / All Groups / Directory Roles / Security Groups]` |

---

### Expected Deliverables

Please provide the following once the application is registered:

- Client ID (Application ID)
- Client Secret (if applicable)
- Directory (Tenant) ID
- Confirmed Redirect URI(s)

---

### Additional Notes (Optional)

- `[Special requirements, e.g., token lifetimes, multi-tenant support, certificate-based auth]`
- `[Point of contact for troubleshooting or ownership]`

---

### Closing

Thank you for your support.  
Please let me know if you need additional information to process this request.

Kind regards,  
`[Your Name]`  
`[Team / Department]`  
`[Contact Information]`

---

## Usage Notes

1. Replace all placeholders `[like this]`.
2. Check/uncheck relevant items under **Purpose**.
3. Use the **Application Details** table for clarity.
4. Include **Additional Notes** only if required.  
