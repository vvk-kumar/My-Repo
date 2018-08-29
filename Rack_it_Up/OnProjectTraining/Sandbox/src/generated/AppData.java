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
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}status"/>
 *         &lt;element ref="{}dateLoaded"/>
 *         &lt;element ref="{}noCardsInWallet"/>
 *         &lt;element ref="{}goalsCreated1to30"/>
 *         &lt;element ref="{}noOfTrigger"/>
 *         &lt;element ref="{}appDownloaded"/>
 *         &lt;element ref="{}mobilePlatform"/>
 *         &lt;element ref="{}appVersion"/>
 *         &lt;element ref="{}appLastAccessed"/>
 *         &lt;element ref="{}login8to21"/>
 *         &lt;element ref="{}login22to84"/>
 *         &lt;element ref="{}login1to7"/>
 *         &lt;element ref="{}idSoggetto"/>
 *         &lt;element ref="{}noCategoriesCreated"/>
 *         &lt;element ref="{}noDescriptionsIncluded"/>
 *         &lt;element ref="{}goalsCreated31to60"/>
 *         &lt;element ref="{}goalsCreated61to365"/>
 *         &lt;element ref="{}latestGoalCreatedDt"/>
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
    "id",
    "status",
    "dateLoaded",
    "noCardsInWallet",
    "goalsCreated1To30",
    "noOfTrigger",
    "appDownloaded",
    "mobilePlatform",
    "appVersion",
    "appLastAccessed",
    "login8To21",
    "login22To84",
    "login1To7",
    "idSoggetto",
    "noCategoriesCreated",
    "noDescriptionsIncluded",
    "goalsCreated31To60",
    "goalsCreated61To365",
    "latestGoalCreatedDt"
})
@XmlRootElement(name = "appData")
public class AppData {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected BigInteger status;
    @XmlElement(required = true)
    protected BigInteger dateLoaded;
    @XmlElement(required = true)
    protected BigInteger noCardsInWallet;
    @XmlElement(name = "goalsCreated1to30", required = true)
    protected BigInteger goalsCreated1To30;
    @XmlElement(required = true)
    protected BigInteger noOfTrigger;
    @XmlElement(required = true)
    protected BigInteger appDownloaded;
    @XmlElement(required = true)
    protected MobilePlatform mobilePlatform;
    @XmlElement(required = true)
    protected AppVersion appVersion;
    @XmlElement(required = true)
    protected BigInteger appLastAccessed;
    @XmlElement(name = "login8to21", required = true)
    protected BigInteger login8To21;
    @XmlElement(name = "login22to84", required = true)
    protected BigInteger login22To84;
    @XmlElement(name = "login1to7", required = true)
    protected BigInteger login1To7;
    @XmlElement(required = true)
    protected BigInteger idSoggetto;
    @XmlElement(required = true)
    protected BigInteger noCategoriesCreated;
    @XmlElement(required = true)
    protected BigInteger noDescriptionsIncluded;
    @XmlElement(name = "goalsCreated31to60", required = true)
    protected BigInteger goalsCreated31To60;
    @XmlElement(name = "goalsCreated61to365", required = true)
    protected BigInteger goalsCreated61To365;
    @XmlElement(required = true)
    protected LatestGoalCreatedDt latestGoalCreatedDt;

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
     * Gets the value of the noCardsInWallet property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoCardsInWallet() {
        return noCardsInWallet;
    }

    /**
     * Sets the value of the noCardsInWallet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoCardsInWallet(BigInteger value) {
        this.noCardsInWallet = value;
    }

    /**
     * Gets the value of the goalsCreated1To30 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGoalsCreated1To30() {
        return goalsCreated1To30;
    }

    /**
     * Sets the value of the goalsCreated1To30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGoalsCreated1To30(BigInteger value) {
        this.goalsCreated1To30 = value;
    }

    /**
     * Gets the value of the noOfTrigger property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoOfTrigger() {
        return noOfTrigger;
    }

    /**
     * Sets the value of the noOfTrigger property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoOfTrigger(BigInteger value) {
        this.noOfTrigger = value;
    }

    /**
     * Gets the value of the appDownloaded property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAppDownloaded() {
        return appDownloaded;
    }

    /**
     * Sets the value of the appDownloaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAppDownloaded(BigInteger value) {
        this.appDownloaded = value;
    }

    /**
     * Gets the value of the mobilePlatform property.
     * 
     * @return
     *     possible object is
     *     {@link MobilePlatform }
     *     
     */
    public MobilePlatform getMobilePlatform() {
        return mobilePlatform;
    }

    /**
     * Sets the value of the mobilePlatform property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobilePlatform }
     *     
     */
    public void setMobilePlatform(MobilePlatform value) {
        this.mobilePlatform = value;
    }

    /**
     * Gets the value of the appVersion property.
     * 
     * @return
     *     possible object is
     *     {@link AppVersion }
     *     
     */
    public AppVersion getAppVersion() {
        return appVersion;
    }

    /**
     * Sets the value of the appVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppVersion }
     *     
     */
    public void setAppVersion(AppVersion value) {
        this.appVersion = value;
    }

    /**
     * Gets the value of the appLastAccessed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAppLastAccessed() {
        return appLastAccessed;
    }

    /**
     * Sets the value of the appLastAccessed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAppLastAccessed(BigInteger value) {
        this.appLastAccessed = value;
    }

    /**
     * Gets the value of the login8To21 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLogin8To21() {
        return login8To21;
    }

    /**
     * Sets the value of the login8To21 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLogin8To21(BigInteger value) {
        this.login8To21 = value;
    }

    /**
     * Gets the value of the login22To84 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLogin22To84() {
        return login22To84;
    }

    /**
     * Sets the value of the login22To84 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLogin22To84(BigInteger value) {
        this.login22To84 = value;
    }

    /**
     * Gets the value of the login1To7 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLogin1To7() {
        return login1To7;
    }

    /**
     * Sets the value of the login1To7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLogin1To7(BigInteger value) {
        this.login1To7 = value;
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
     * Gets the value of the noCategoriesCreated property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoCategoriesCreated() {
        return noCategoriesCreated;
    }

    /**
     * Sets the value of the noCategoriesCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoCategoriesCreated(BigInteger value) {
        this.noCategoriesCreated = value;
    }

    /**
     * Gets the value of the noDescriptionsIncluded property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoDescriptionsIncluded() {
        return noDescriptionsIncluded;
    }

    /**
     * Sets the value of the noDescriptionsIncluded property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoDescriptionsIncluded(BigInteger value) {
        this.noDescriptionsIncluded = value;
    }

    /**
     * Gets the value of the goalsCreated31To60 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGoalsCreated31To60() {
        return goalsCreated31To60;
    }

    /**
     * Sets the value of the goalsCreated31To60 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGoalsCreated31To60(BigInteger value) {
        this.goalsCreated31To60 = value;
    }

    /**
     * Gets the value of the goalsCreated61To365 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGoalsCreated61To365() {
        return goalsCreated61To365;
    }

    /**
     * Sets the value of the goalsCreated61To365 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGoalsCreated61To365(BigInteger value) {
        this.goalsCreated61To365 = value;
    }

    /**
     * Gets the value of the latestGoalCreatedDt property.
     * 
     * @return
     *     possible object is
     *     {@link LatestGoalCreatedDt }
     *     
     */
    public LatestGoalCreatedDt getLatestGoalCreatedDt() {
        return latestGoalCreatedDt;
    }

    /**
     * Sets the value of the latestGoalCreatedDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestGoalCreatedDt }
     *     
     */
    public void setLatestGoalCreatedDt(LatestGoalCreatedDt value) {
        this.latestGoalCreatedDt = value;
    }

}