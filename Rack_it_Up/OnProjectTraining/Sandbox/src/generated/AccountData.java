//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.31 at 01:03:58 PM IST 
//


package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}status"/>
 *         &lt;element ref="{}provinciaIre"/>
 *         &lt;element ref="{}provinciaIdo"/>
 *         &lt;element ref="{}accOpenedDate"/>
 *         &lt;element ref="{}accClosingDate"/>
 *         &lt;element ref="{}accValidity"/>
 *         &lt;element ref="{}crdOpenDate"/>
 *         &lt;element ref="{}crdClosingDate"/>
 *         &lt;element ref="{}dateLoaded"/>
 *         &lt;element ref="{}surName"/>
 *         &lt;element ref="{}dob"/>
 *         &lt;element ref="{}cf"/>
 *         &lt;element ref="{}cfHash"/>
 *         &lt;element ref="{}comuneIre"/>
 *         &lt;element ref="{}capIre"/>
 *         &lt;element ref="{}comuneIdo"/>
 *         &lt;element ref="{}capIdo"/>
 *         &lt;element ref="{}mobileNo"/>
 *         &lt;element ref="{}accType"/>
 *         &lt;element ref="{}crdStatus"/>
 *         &lt;element ref="{}crdType"/>
 *         &lt;element ref="{}ibCode"/>
 *         &lt;element ref="{}idSoggetto"/>
 *         &lt;element ref="{}email"/>
 *         &lt;element ref="{}crdStatusDescription"/>
 *         &lt;element ref="{}cambioStatoFisicita"/>
 *         &lt;element ref="{}crdPosActiveStatus"/>
 *         &lt;element ref="{}crdAtmActiveStatus"/>
 *         &lt;element ref="{}crdEcomActiveStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "id",
    "status",
    "provinciaIre",
    "provinciaIdo",
    "accOpenedDate",
    "accClosingDate",
    "accValidity",
    "crdOpenDate",
    "crdClosingDate",
    "dateLoaded",
    "surName",
    "dob",
    "cf",
    "cfHash",
    "comuneIre",
    "capIre",
    "comuneIdo",
    "capIdo",
    "mobileNo",
    "accType",
    "crdStatus",
    "crdType",
    "ibCode",
    "idSoggetto",
    "email",
    "crdStatusDescription",
    "cambioStatoFisicita",
    "crdPosActiveStatus",
    "crdAtmActiveStatus",
    "crdEcomActiveStatus"
})
@XmlRootElement(name = "accountData")
public class AccountData {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected BigInteger status;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String provinciaIre;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String provinciaIdo;
    @XmlElement(required = true)
    protected BigInteger accOpenedDate;
    @XmlElement(required = true)
    protected AccClosingDate accClosingDate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String accValidity;
    @XmlElement(required = true)
    protected BigInteger crdOpenDate;
    @XmlElement(required = true)
    protected CrdClosingDate crdClosingDate;
    @XmlElement(required = true)
    protected BigInteger dateLoaded;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String surName;
    @XmlElement(required = true)
    protected BigInteger dob;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cf;
    @XmlElement(required = true)
    protected String cfHash;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String comuneIre;
    @XmlElement(required = true)
    protected BigInteger capIre;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String comuneIdo;
    @XmlElement(required = true)
    protected BigInteger capIdo;
    @XmlElement(required = true)
    protected BigInteger mobileNo;
    @XmlElement(required = true)
    protected String accType;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdStatus;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdType;
    @XmlElement(required = true)
    protected BigInteger ibCode;
    @XmlElement(required = true)
    protected BigInteger idSoggetto;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdStatusDescription;
    @XmlElement(required = true)
    protected BigInteger cambioStatoFisicita;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdPosActiveStatus;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdAtmActiveStatus;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String crdEcomActiveStatus;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStatus(BigInteger value) {
        this.status = value;
    }

    /**
     * Gets the value of the provinciaIre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinciaIre() {
        return provinciaIre;
    }

    /**
     * Sets the value of the provinciaIre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinciaIre(String value) {
        this.provinciaIre = value;
    }

    /**
     * Gets the value of the provinciaIdo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinciaIdo() {
        return provinciaIdo;
    }

    /**
     * Sets the value of the provinciaIdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinciaIdo(String value) {
        this.provinciaIdo = value;
    }

    /**
     * Gets the value of the accOpenedDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAccOpenedDate() {
        return accOpenedDate;
    }

    /**
     * Sets the value of the accOpenedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAccOpenedDate(BigInteger value) {
        this.accOpenedDate = value;
    }

    /**
     * Gets the value of the accClosingDate property.
     * 
     * @return
     *     possible object is
     *     {@link AccClosingDate }
     *     
     */
    public AccClosingDate getAccClosingDate() {
        return accClosingDate;
    }

    /**
     * Sets the value of the accClosingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccClosingDate }
     *     
     */
    public void setAccClosingDate(AccClosingDate value) {
        this.accClosingDate = value;
    }

    /**
     * Gets the value of the accValidity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccValidity() {
        return accValidity;
    }

    /**
     * Sets the value of the accValidity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccValidity(String value) {
        this.accValidity = value;
    }

    /**
     * Gets the value of the crdOpenDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCrdOpenDate() {
        return crdOpenDate;
    }

    /**
     * Sets the value of the crdOpenDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCrdOpenDate(BigInteger value) {
        this.crdOpenDate = value;
    }

    /**
     * Gets the value of the crdClosingDate property.
     * 
     * @return
     *     possible object is
     *     {@link CrdClosingDate }
     *     
     */
    public CrdClosingDate getCrdClosingDate() {
        return crdClosingDate;
    }

    /**
     * Sets the value of the crdClosingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrdClosingDate }
     *     
     */
    public void setCrdClosingDate(CrdClosingDate value) {
        this.crdClosingDate = value;
    }

    /**
     * Gets the value of the dateLoaded property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDateLoaded() {
        return dateLoaded;
    }

    /**
     * Sets the value of the dateLoaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDateLoaded(BigInteger value) {
        this.dateLoaded = value;
    }

    /**
     * Gets the value of the surName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Sets the value of the surName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurName(String value) {
        this.surName = value;
    }

    /**
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDob() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDob(BigInteger value) {
        this.dob = value;
    }

    /**
     * Gets the value of the cf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCf() {
        return cf;
    }

    /**
     * Sets the value of the cf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCf(String value) {
        this.cf = value;
    }

    /**
     * Gets the value of the cfHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfHash() {
        return cfHash;
    }

    /**
     * Sets the value of the cfHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfHash(String value) {
        this.cfHash = value;
    }

    /**
     * Gets the value of the comuneIre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneIre() {
        return comuneIre;
    }

    /**
     * Sets the value of the comuneIre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneIre(String value) {
        this.comuneIre = value;
    }

    /**
     * Gets the value of the capIre property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCapIre() {
        return capIre;
    }

    /**
     * Sets the value of the capIre property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCapIre(BigInteger value) {
        this.capIre = value;
    }

    /**
     * Gets the value of the comuneIdo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneIdo() {
        return comuneIdo;
    }

    /**
     * Sets the value of the comuneIdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneIdo(String value) {
        this.comuneIdo = value;
    }

    /**
     * Gets the value of the capIdo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCapIdo() {
        return capIdo;
    }

    /**
     * Sets the value of the capIdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCapIdo(BigInteger value) {
        this.capIdo = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMobileNo(BigInteger value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the accType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccType() {
        return accType;
    }

    /**
     * Sets the value of the accType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccType(String value) {
        this.accType = value;
    }

    /**
     * Gets the value of the crdStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdStatus() {
        return crdStatus;
    }

    /**
     * Sets the value of the crdStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdStatus(String value) {
        this.crdStatus = value;
    }

    /**
     * Gets the value of the crdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdType() {
        return crdType;
    }

    /**
     * Sets the value of the crdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdType(String value) {
        this.crdType = value;
    }

    /**
     * Gets the value of the ibCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIbCode() {
        return ibCode;
    }

    /**
     * Sets the value of the ibCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIbCode(BigInteger value) {
        this.ibCode = value;
    }

    /**
     * Gets the value of the idSoggetto property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdSoggetto() {
        return idSoggetto;
    }

    /**
     * Sets the value of the idSoggetto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdSoggetto(BigInteger value) {
        this.idSoggetto = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the crdStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdStatusDescription() {
        return crdStatusDescription;
    }

    /**
     * Sets the value of the crdStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdStatusDescription(String value) {
        this.crdStatusDescription = value;
    }

    /**
     * Gets the value of the cambioStatoFisicita property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCambioStatoFisicita() {
        return cambioStatoFisicita;
    }

    /**
     * Sets the value of the cambioStatoFisicita property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCambioStatoFisicita(BigInteger value) {
        this.cambioStatoFisicita = value;
    }

    /**
     * Gets the value of the crdPosActiveStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdPosActiveStatus() {
        return crdPosActiveStatus;
    }

    /**
     * Sets the value of the crdPosActiveStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdPosActiveStatus(String value) {
        this.crdPosActiveStatus = value;
    }

    /**
     * Gets the value of the crdAtmActiveStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdAtmActiveStatus() {
        return crdAtmActiveStatus;
    }

    /**
     * Sets the value of the crdAtmActiveStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdAtmActiveStatus(String value) {
        this.crdAtmActiveStatus = value;
    }

    /**
     * Gets the value of the crdEcomActiveStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdEcomActiveStatus() {
        return crdEcomActiveStatus;
    }

    /**
     * Sets the value of the crdEcomActiveStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdEcomActiveStatus(String value) {
        this.crdEcomActiveStatus = value;
    }

}