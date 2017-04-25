package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			if (!theArchive.commitNeeded) {
				pageContext.getOut().print(theArchive.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			return theArchive.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Archive for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			theArchive.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for subjectURI tag ");
		}
	}
}

