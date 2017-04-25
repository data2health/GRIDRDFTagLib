package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasRelatedInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasRelatedInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasRelatedInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasRelatedInverseIterator theArchiveHasRelatedInverseIterator = (ArchiveHasRelatedInverseIterator)findAncestorWithClass(this, ArchiveHasRelatedInverseIterator.class);
			pageContext.getOut().print(theArchiveHasRelatedInverseIterator.getHasRelatedInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

