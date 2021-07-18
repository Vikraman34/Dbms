/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPack;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Viki
 */
@Entity
@Table(name = "EMP_PAYROLL", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "EmpPayroll.findAll", query = "SELECT e FROM EmpPayroll e"),
    @NamedQuery(name = "EmpPayroll.findByEid", query = "SELECT e FROM EmpPayroll e WHERE e.eid = :eid"),
    @NamedQuery(name = "EmpPayroll.findByEname", query = "SELECT e FROM EmpPayroll e WHERE e.ename = :ename"),
    @NamedQuery(name = "EmpPayroll.findByDob", query = "SELECT e FROM EmpPayroll e WHERE e.dob = :dob"),
    @NamedQuery(name = "EmpPayroll.findBySex", query = "SELECT e FROM EmpPayroll e WHERE e.sex = :sex"),
    @NamedQuery(name = "EmpPayroll.findByDesignation", query = "SELECT e FROM EmpPayroll e WHERE e.designation = :designation"),
    @NamedQuery(name = "EmpPayroll.findByBasic", query = "SELECT e FROM EmpPayroll e WHERE e.basic = :basic"),
    @NamedQuery(name = "EmpPayroll.findByDa", query = "SELECT e FROM EmpPayroll e WHERE e.da = :da"),
    @NamedQuery(name = "EmpPayroll.findByHra", query = "SELECT e FROM EmpPayroll e WHERE e.hra = :hra"),
    @NamedQuery(name = "EmpPayroll.findByPf", query = "SELECT e FROM EmpPayroll e WHERE e.pf = :pf"),
    @NamedQuery(name = "EmpPayroll.findByMc", query = "SELECT e FROM EmpPayroll e WHERE e.mc = :mc"),
    @NamedQuery(name = "EmpPayroll.findByGross", query = "SELECT e FROM EmpPayroll e WHERE e.gross = :gross"),
    @NamedQuery(name = "EmpPayroll.findByTotDeduc", query = "SELECT e FROM EmpPayroll e WHERE e.totDeduc = :totDeduc"),
    @NamedQuery(name = "EmpPayroll.findByNetPay", query = "SELECT e FROM EmpPayroll e WHERE e.netPay = :netPay")})
public class EmpPayroll implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EID")
    private Integer eid;
    @Column(name = "ENAME")
    private String ename;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "DESIGNATION")
    private String designation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASIC")
    private BigDecimal basic;
    @Column(name = "DA")
    private BigDecimal da;
    @Column(name = "HRA")
    private BigDecimal hra;
    @Column(name = "PF")
    private BigDecimal pf;
    @Column(name = "MC")
    private BigDecimal mc;
    @Column(name = "GROSS")
    private BigDecimal gross;
    @Column(name = "TOT_DEDUC")
    private BigDecimal totDeduc;
    @Column(name = "NET_PAY")
    private BigDecimal netPay;

    public EmpPayroll() {
    }

    public EmpPayroll(Integer eid) {
        this.eid = eid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        Integer oldEid = this.eid;
        this.eid = eid;
        changeSupport.firePropertyChange("eid", oldEid, eid);
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        String oldEname = this.ename;
        this.ename = ename;
        changeSupport.firePropertyChange("ename", oldEname, ename);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        String oldDesignation = this.designation;
        this.designation = designation;
        changeSupport.firePropertyChange("designation", oldDesignation, designation);
    }

    public BigDecimal getBasic() {
        return basic;
    }

    public void setBasic(BigDecimal basic) {
        BigDecimal oldBasic = this.basic;
        this.basic = basic;
        changeSupport.firePropertyChange("basic", oldBasic, basic);
    }

    public BigDecimal getDa() {
        return da;
    }

    public void setDa(BigDecimal da) {
        BigDecimal oldDa = this.da;
        this.da = da;
        changeSupport.firePropertyChange("da", oldDa, da);
    }

    public BigDecimal getHra() {
        return hra;
    }

    public void setHra(BigDecimal hra) {
        BigDecimal oldHra = this.hra;
        this.hra = hra;
        changeSupport.firePropertyChange("hra", oldHra, hra);
    }

    public BigDecimal getPf() {
        return pf;
    }

    public void setPf(BigDecimal pf) {
        BigDecimal oldPf = this.pf;
        this.pf = pf;
        changeSupport.firePropertyChange("pf", oldPf, pf);
    }

    public BigDecimal getMc() {
        return mc;
    }

    public void setMc(BigDecimal mc) {
        BigDecimal oldMc = this.mc;
        this.mc = mc;
        changeSupport.firePropertyChange("mc", oldMc, mc);
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        BigDecimal oldGross = this.gross;
        this.gross = gross;
        changeSupport.firePropertyChange("gross", oldGross, gross);
    }

    public BigDecimal getTotDeduc() {
        return totDeduc;
    }

    public void setTotDeduc(BigDecimal totDeduc) {
        BigDecimal oldTotDeduc = this.totDeduc;
        this.totDeduc = totDeduc;
        changeSupport.firePropertyChange("totDeduc", oldTotDeduc, totDeduc);
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        BigDecimal oldNetPay = this.netPay;
        this.netPay = netPay;
        changeSupport.firePropertyChange("netPay", oldNetPay, netPay);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpPayroll)) {
            return false;
        }
        EmpPayroll other = (EmpPayroll) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyPack.EmpPayroll[ eid=" + eid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
