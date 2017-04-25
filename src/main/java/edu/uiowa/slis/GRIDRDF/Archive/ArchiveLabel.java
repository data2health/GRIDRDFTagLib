package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			if (!theArchive.commitNeeded) {
				pageContext.getOut().print(theArchive.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			return theArchive.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Archive for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Archive theArchive = (Archive)findAncestorWithClass(this, Archive.class);
			theArchive.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for label tag ");
		}
	}
}

